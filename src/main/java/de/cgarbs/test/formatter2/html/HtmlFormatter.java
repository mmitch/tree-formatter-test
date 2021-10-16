/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter2.html;

import de.cgarbs.test.tree.MyLink;
import de.cgarbs.test.tree.MyList;
import de.cgarbs.test.tree.MyNode;
import de.cgarbs.test.tree.MyText;

public class HtmlFormatter
{
	private final static MyLinkToHtml linkToHtml = new MyLinkToHtml();
	private final static MyListToHtml listToHtml = new MyListToHtml();
	private final static MyTextToHtml textToHtml = new MyTextToHtml();

	public String toHtml(MyNode root)
	{
		StringBuilder html = new StringBuilder();
		appendHtml(html, root);
		return html.toString();
	}

	static void appendHtml(StringBuilder html, MyNode node)
	{
		if (node instanceof MyLink)
		{
			linkToHtml.appendHtml(html, (MyLink) node);
		}
		else if (node instanceof MyList)
		{
			listToHtml.appendHtml(html, (MyList) node);
		}
		else if (node instanceof MyText)
		{
			textToHtml.appendHtml(html, (MyText) node);
		}
		else
		{
			throw new RuntimeException("no handler for " + node.getClass());
		}
	}
}
