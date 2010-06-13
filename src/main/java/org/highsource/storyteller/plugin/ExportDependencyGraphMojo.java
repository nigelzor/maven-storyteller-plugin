package org.highsource.storyteller.plugin;

import java.io.File;
import java.io.IOException;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.highsource.storyteller.artifact.graph.ext.VertexNameProviders;
import org.highsource.storyteller.jgrapht.ext.AutoGraphExporter;
import org.highsource.storyteller.jgrapht.ext.GraphExporter;
import org.jfrog.maven.annomojo.annotations.MojoGoal;
import org.jfrog.maven.annomojo.annotations.MojoParameter;
import org.jfrog.maven.annomojo.annotations.MojoPhase;
import org.jfrog.maven.annomojo.annotations.MojoRequiresDependencyResolution;
import org.jfrog.maven.annomojo.annotations.MojoRequiresProject;
import org.jgrapht.graph.DefaultEdge;

@MojoGoal("export-dependency-graph")
@MojoPhase("verify")
@MojoRequiresProject(false)
@MojoRequiresDependencyResolution("test")
public class ExportDependencyGraphMojo extends AbstractDependencyGraphMojo {

	protected GraphExporter<Artifact, DefaultEdge> graphExporter;

	@MojoParameter(required = true, expression = "${file}", defaultValue = "graphFile.graphml")
	private File file;

	/**
	 * The plugin uses GraphViz package to render graphs in formats like PDF and
	 * so on. For this to work, you'll need to specify the path to the
	 * executable <code>dot</code> of GraphViz in this property.
	 */
	@MojoParameter(expression = "${graphViz.dotFile}", defaultValue = "dot")
	protected String graphVizDotFile;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		super.execute();

		// Create a graph exporter
		this.graphExporter = new AutoGraphExporter<Artifact, DefaultEdge>(graphVizDotFile);
		// Export archive dependency graph
		try {
			this.graphExporter.exportGraph(artifactGraph, VertexNameProviders.ARTIFACT_VERTEX_NAME_PROVIDER, file,
					getLog());
		} catch (IOException ioex) {
			throw new MojoExecutionException("Error exporting graph.", ioex);
		}

	}

}