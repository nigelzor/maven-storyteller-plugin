package org.highsource.storyteller.jgrapht.ext;

public class PNGGraphExporter<V, E> extends GraphVizGraphExporter<V, E> {

	public PNGGraphExporter(String graphVizDotFile) {
		super(graphVizDotFile);
	}

	@Override
	protected String getFormat() {
		return "png";
	}

}
