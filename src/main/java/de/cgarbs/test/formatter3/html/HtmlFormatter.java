/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.html;

import de.cgarbs.test.formatter3.FormatterSet;
import de.cgarbs.test.tree.MyNode;

public class HtmlFormatter
{
	@SuppressWarnings("rawtypes")
	private static final FormatterSet<ToHtml> formatters = new FormatterSet<ToHtml>(ToHtml.class);

	public String toHtml(MyNode root)
	{
		StringBuilder html = new StringBuilder();
		appendHtml(html, root);
		return html.toString();
	}

	static <T extends MyNode> void appendHtml(StringBuilder html, T node)
	{
		@SuppressWarnings("unchecked")
		ToHtml<T> formatter = formatters.getFor(node);
		T typedNode = formatter.responsibleFor().cast(node);
		formatter.appendHtml(html, typedNode);
	}
}
