/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.html;

import de.cgarbs.test.tree.MyLink;
import de.cgarbs.test.tree.MyNode;

public class MyLinkToHtml implements ToHtml<MyLink>
{

	@Override
	public void appendHtml(StringBuilder html, MyLink link)
	{
		html.append("<a href=\"").append(link.getTarget()).append("\">");
		link.getChildren().forEach(child -> HtmlFormatter.appendHtml(html, child));
		html.append("</a>");
	}

	@Override
	public Class<MyLink> responsibleFor()
	{
		return MyLink.class;
	}

	@Override
	public void appendHtmlUntyped(StringBuilder html, MyNode link)
	{
		appendHtml(html, (MyLink) link);
	}

}
