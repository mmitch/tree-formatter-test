/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.html;

import de.cgarbs.test.formatter3.FormatterSet;
import de.cgarbs.test.tree.MyNode;

public class HtmlFormatter
{
	private static final FormatterSet<ToHtml> formatters = new FormatterSet(ToHtml.class);

	public String toHtml(MyNode root)
	{
		StringBuilder html = new StringBuilder();
		appendHtml(html, root);
		return html.toString();
	}

	static void appendHtml(StringBuilder html, MyNode node)
	{
		formatters.getFor(node).appendHtmlUntyped(html, node);
	}
}
