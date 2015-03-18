# Maven Storyteller Plugin #
For when `dependency:tree` isn't good enough: Export your project's dependency graph as DOT, PNG, GML, GraphML, or PDF.

This project is a continuation of the original [Maven Storyteller Plugin](http://confluence.highsource.org/display/MSTP/Home), which never had a public release.

## Basic Usage ##
Add plugin repository:
```
<pluginRepositories>
	<pluginRepository>
		<id>maven-storyteller-plugin.googlecode.com</id>
		<url>http://maven-storyteller-plugin.googlecode.com/svn/snapshots</url>
	</pluginRepository>
</pluginRepositories>
```

From the command-line:
```
mvn org.highsource.storyteller:maven-storyteller-plugin:0.2-SNAPSHOT:export-dependency-graph -Dfile=depends.png
```

Or add project report:
```
<reporting>
	<plugins>
		<plugin>
			<groupId>org.highsource.storyteller</groupId>
			<artifactId>maven-storyteller-plugin</artifactId>
			<version>0.2-SNAPSHOT</version>
		</plugin>
	</plugins>
</reporting>
```