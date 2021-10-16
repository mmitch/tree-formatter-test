/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter2.markdown;

import de.cgarbs.test.tree.MyLink;
import de.cgarbs.test.tree.MyList;
import de.cgarbs.test.tree.MyNode;
import de.cgarbs.test.tree.MyText;

public class MarkdownFormatter
{
	private final static MyLinkToMarkdown linkToMarkdown = new MyLinkToMarkdown();
	private final static MyListToMarkdown listToMarkdown = new MyListToMarkdown();
	private final static MyTextToMarkdown textToMarkdown = new MyTextToMarkdown();

	public String toMarkdown(MyNode root)
	{
		StringBuilder markdown = new StringBuilder();
		appendMarkdown(markdown, root);
		return markdown.toString();
	}

	static void appendMarkdown(StringBuilder markdown, MyNode node)
	{
		if (node instanceof MyLink)
		{
			linkToMarkdown.appendMarkdown(markdown, (MyLink) node);
		}
		else if (node instanceof MyList)
		{
			listToMarkdown.appendMarkdown(markdown, (MyList) node);
		}
		else if (node instanceof MyText)
		{
			textToMarkdown.appendMarkdown(markdown, (MyText) node);
		}
		else
		{
			throw new RuntimeException("no handler for " + node.getClass());
		}
	}
}
