/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter2.html;

import de.cgarbs.test.tree.MyList;
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
}
