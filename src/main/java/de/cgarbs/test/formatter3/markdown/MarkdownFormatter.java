/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.markdown;

import de.cgarbs.test.formatter3.FormatterSet;
import de.cgarbs.test.tree.MyNode;

public class MarkdownFormatter
{
	@SuppressWarnings("rawtypes")
	private static final FormatterSet<ToMarkdown> formatters = new FormatterSet<ToMarkdown>(ToMarkdown.class);

	public String toMarkdown(MyNode root)
	{
		StringBuilder markdown = new StringBuilder();
		appendMarkdown(markdown, root);
		return markdown.toString();
	}

	static <T extends MyNode> void appendMarkdown(StringBuilder markdown, T node)
	{
		@SuppressWarnings("unchecked")
		ToMarkdown<T> formatter = formatters.getFor(node);
		T typedNode = formatter.responsibleFor().cast(node);
		formatter.appendMarkdown(markdown, typedNode);
	}
}
