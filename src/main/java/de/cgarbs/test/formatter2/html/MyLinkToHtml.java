/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter2.html;

import de.cgarbs.test.tree.MyLink;

public class MyLinkToHtml implements ToHtml<MyLink>
{

	@Override
	public void appendHtml(StringBuilder html, MyLink link)
	{
		html.append("<a href=\"").append(link.getTarget()).append("\">");
		link.getChildren().forEach(child -> HtmlFormatter.appendHtml(html, child));
		html.append("</a>");
	}

}
