
//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
// ant.mkdir(dir:"/tmp/newplugin/grails-app/jobs")
//

def ant = binding.variables['ant'] ?: binding.variables['Ant']

// TODO this is ancient - remove in next version
if (new File(basedir, 'grails-app/conf/SearchablePluginConfiguration.groovy').exists()) {
    println """
    
        STOP!

        It looks like you have an older version of the Searchable Plugin config file at:

            grails-app/conf/SearchablePluginConfiguration.groovy

        The file name has changed, so you need to rename it to:

            grails-app/conf/SearchableConfiguration.groovy
"""
}

// @since 0.5
if (new File(basedir, 'grails-app/conf/SearchableConfiguration.groovy').exists()) {
    println """

        STOP!

        You have a deprecated Searchable Plugin Configuration file:

            grails-app/conf/SearchableConfiguration.groovy

        Support for this configuration file will be removed
        in the next version!

        Configuration for the Searchable Plugin should now be defined
        with the standard Grails config mechanism.

        You can either (1) add the plugin's config properties to
        "grails-app/conf/Config.groovy", or (2) provide a
        plugin-specific file called "grails-app/conf/Searchable.groovy".

        Run "grails install-searchable-config" to try the second
        option without affecting your existing configuration,
        but you will need to merge your own settings into the new
        configuration file.

"""
    ant.input("[Please acknowledge this message by pressing ENTER]")
}

println """

Thanks for installing the Grails Searchable Plugin!


Documentation is available at http://grails.org/Searchable+Plugin

Help is available from user@grails.codehaus.org

Issues and improvements should be raised at http://jira.codehaus.org/browse/GRAILSPLUGINS

If you are upgrading from a previous release, please see http://grails.org/Searchable+Plugin+-+Releases

"""
