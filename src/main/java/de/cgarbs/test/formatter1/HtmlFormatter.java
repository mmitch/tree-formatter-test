/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter1;

import de.cgarbs.test.tree.MyLink;
import de.cgarbs.test.tree.MyList;
import de.cgarbs.test.tree.MyNode;
import de.cgarbs.test.tree.MyText;

public class HtmlFormatter
{
	public String toHtml(MyNode root)
	{
		StringBuilder html = new StringBuilder();
		appendHtml(html, root);
		return html.toString();
	}

	private static void appendHtml(StringBuilder html, MyNode node)
	{
		if (node instanceof MyLink)
		{
			appendLink(html, (MyLink) node);
		}
		else if (node instanceof MyList)
		{
			appendList(html, (MyList) node);
		}
		else if (node instanceof MyText)
		{
			appendText(html, (MyText) node);
		}
		else
		{
			throw new RuntimeException("no handler for " + node.getClass());
		}
	}

	private static void appendLink(StringBuilder html, MyLink link)
	{
		html.append("<a href=\"").append(link.getTarget()).append("\">");
		link.getChildren().forEach(child -> appendHtml(html, child));
		html.append("</a>");
	}

	private static void appendList(StringBuilder html, MyList list)
	{
		html.append("<ul>\n");
		list.getChildren().forEach(child -> {
			html.append(" <li>");
			appendHtml(html, child);
			html.append("</li>\n");
		});
		html.append("</ul>");

	}

	private static void appendText(StringBuilder html, MyText text)
	{
		html.append(text.getText());
	}
}
