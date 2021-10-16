/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.html;

import de.cgarbs.test.tree.MyList;
import de.cgarbs.test.tree.MyNode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyListToHtml implements ToHtml<MyList>
{
	@Override
	public void appendHtml(StringBuilder html, MyList list)
	{
		html.append("<ul>\n");
		list.getChildren().forEach(child -> {
			html.append(" <li>");
			HtmlFormatter.appendHtml(html, child);
			html.append("</li>\n");
		});
		html.append("</ul>");
	}

	@Override
	public Class<MyList> responsibleFor()
	{
		return MyList.class;
	}

	@Override
	public void appendHtmlUntyped(StringBuilder html, MyNode list)
	{
		appendHtml(html, (MyList) list);
	}
}
