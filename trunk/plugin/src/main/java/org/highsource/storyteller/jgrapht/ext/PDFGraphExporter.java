package org.highsource.storyteller.jgrapht.ext;

public class PDFGraphExporter<V, E> extends GraphVizGraphExporter<V, E> {

	public PDFGraphExporter(String graphVizDotFile) {
		super(graphVizDotFile);
	}

	@Override
	protected String getFormat() {
		return "pdf";
	}

}
