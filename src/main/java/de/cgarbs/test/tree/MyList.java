/*
 * Copyright 2021 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.test.tree;

import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyList implements MyNode
{
	private final List<MyNode> children;

	public static MyList list(MyNode... items)
	{
		return MyList.builder().children(Arrays.asList(items)).build();
	}
}
