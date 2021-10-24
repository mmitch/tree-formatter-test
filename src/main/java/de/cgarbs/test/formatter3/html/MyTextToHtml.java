/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.formatter3.html;

import de.cgarbs.test.tree.MyText;

public class MyTextToHtml implements ToHtml<MyText>
{
	@Override
	public void appendHtml(StringBuilder html, MyText text)
	{
		html.append(text.getText());
	}

	@Override
	public Class<MyText> responsibleFor()
	{
		return MyText.class;
	}
}
