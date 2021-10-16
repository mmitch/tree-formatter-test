/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.markdown;

import de.cgarbs.test.tree.MyList;
import de.cgarbs.test.tree.MyNode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyListToMarkdown implements ToMarkdown<MyList>
{
	@Override
	public void appendMarkdown(StringBuilder markdown, MyList list)
	{
		list.getChildren().forEach(child -> {
			markdown.append(" *  ");
			MarkdownFormatter.appendMarkdown(markdown, child);
			markdown.append("\n");
		});
	}

	@Override
	public Class<MyList> responsibleFor()
	{
		return MyList.class;
	}

	@Override
	public void appendMarkdownUntyped(StringBuilder markdown, MyNode list)
	{
		appendMarkdown(markdown, (MyList) list);
	}
}
