/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter1;

import de.cgarbs.test.tree.MyLink;
import de.cgarbs.test.tree.MyList;
import de.cgarbs.test.tree.MyNode;
import de.cgarbs.test.tree.MyText;

public class MarkdownFormatter
{
	public String toMarkdown(MyNode root)
	{
		StringBuilder markdown = new StringBuilder();
		appendMarkdown(markdown, root);
		return markdown.toString();
	}

	private static void appendMarkdown(StringBuilder markdown, MyNode node)
	{
		if (node instanceof MyLink)
		{
			appendLink(markdown, (MyLink) node);
		}
		else if (node instanceof MyList)
		{
			appendList(markdown, (MyList) node);
		}
		else if (node instanceof MyText)
		{
			appendText(markdown, (MyText) node);
		}
		else
		{
			throw new RuntimeException("no handler for " + node.getClass());
		}
	}

	private static void appendLink(StringBuilder markdown, MyLink link)
	{
		markdown.append("[");
		link.getChildren().forEach(child -> appendMarkdown(markdown, child));
		markdown.append("](").append(link.getTarget()).append(")");
	}

	private static void appendList(StringBuilder markdown, MyList list)
	{
		list.getChildren().forEach(child -> {
			markdown.append(" *  ");
			appendMarkdown(markdown, child);
			markdown.append("\n");
		});

	}

	private static void appendText(StringBuilder markdown, MyText text)
	{
		markdown.append(text.getText());
	}
}
