/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.markdown;

import de.cgarbs.test.tree.MyNode;
import de.cgarbs.test.tree.MyText;

public class MyTextToMarkdown implements ToMarkdown<MyText>
{

	@Override
	public void appendMarkdown(StringBuilder markdown, MyText text)
	{
		markdown.append(text.getText());
	}

	@Override
	public Class<MyText> responsibleFor()
	{
		return MyText.class;
	}

	@Override
	public void appendMarkdownUntyped(StringBuilder markdown, MyNode text)
	{
		appendMarkdown(markdown, (MyText) text);
	}

}
