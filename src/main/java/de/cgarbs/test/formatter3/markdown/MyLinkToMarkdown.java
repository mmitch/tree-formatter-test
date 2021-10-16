/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.markdown;

import de.cgarbs.test.tree.MyLink;
import de.cgarbs.test.tree.MyNode;

public class MyLinkToMarkdown implements ToMarkdown<MyLink>
{

	@Override
	public void appendMarkdown(StringBuilder markdown, MyLink link)
	{
		markdown.append("[");
		link.getChildren().forEach(child -> MarkdownFormatter.appendMarkdown(markdown, child));
		markdown.append("](").append(link.getTarget()).append(")");
	}

	@Override
	public Class<MyLink> responsibleFor()
	{
		return MyLink.class;
	}

	@Override
	public void appendMarkdownUntyped(StringBuilder markdown, MyNode link)
	{
		appendMarkdown(markdown, (MyLink) link);
	}

}
