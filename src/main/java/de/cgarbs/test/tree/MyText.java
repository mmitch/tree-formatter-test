/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.tree;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyText implements MyNode
{
	private final String text;

	@Override
	public List<MyNode> getChildren()
	{
		// we are atomic, no further children
		return List.of();
	}

	public static MyText text(String text)
	{
		return MyText.builder().text(text).build();
	}
}
