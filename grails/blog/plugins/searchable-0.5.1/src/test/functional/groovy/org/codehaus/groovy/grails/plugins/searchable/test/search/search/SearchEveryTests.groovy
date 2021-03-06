/*
 * Copyright 2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.groovy.grails.plugins.searchable.test.search.search

import org.codehaus.groovy.grails.plugins.searchable.test.SearchableFunctionalTestCase;

/**
 * @author Maurice Nicholson
 */
class SearchEveryTests extends SearchableFunctionalTestCase {
    def searchableService

    public getDomainClasses() {
        return [Post, Comment]
    }

    void setUp() {
        super.setUp()

        def posts = []
        def comments = []
        for (i in 0..<100) {
            def post = new Post(id: i as Long, title: "I live to post" + (i % 2 == 0 ? " and it's even" : " it's odd"), post: "posty, posty", comments: new HashSet())
            for (j in 0..<5) {
                def comment = new Comment(id: comments.size() as Long, summary: "I love to comment" + (comments.size() % 5 == 0 ? "ah ha ah" : ''), comment: "commenty, commenty", post: post)
                post.comments << comment
                comments << comment
            }
            posts << post
        }
        assert posts.size() == 100
        assert comments.size() == 500

        (posts + comments).each { it.index() }
    }

    void testServiceSearchEveryMethod() {
        def results = searchableService.searchEvery("live OR love")
        assert results.size() == 600
        assert results*.class.unique() == [Post, Comment]
    }

    void testClassSearchEveryMethod() {
        def results = Post.searchEvery("posty") // should match all, thru post body
        assert results.size() == 100
        assert results*.class.unique() == [Post]

        results = Post.searchEvery("even") // should match half, thru title
        assert results.size() == 50
        assert results*.class.unique() == [Post]

        results = Post.searchEvery("odd") // should match half, thru title
        assert results.size() == 50
        assert results*.class.unique() == [Post]

        results = Comment.searchEvery("commenty") // should match all
        assert results.size() == 500
        assert results*.class.unique() == [Comment]

        results = Comment.searchEvery("ah") // should match 1/5
        assert results.size() == 100
        assert results*.class.unique() == [Comment]

        shouldFail {
            results = Post.searchEvery("[this is a bad query]")
        }

        // should not fail
        results = Post.searchEvery("[this is a bad query]", [escape: true])

        // "withHighlighter" option
        def highlights = []
        results = Post.searchEvery("posty", withHighlighter: { highlighter, index, sr ->
            highlights[index] = highlighter.fragment("post")
            assert sr[index] instanceof Post
        })
        assert highlights
        assert highlights.findAll { it }.size() == results.size()
    }
}
