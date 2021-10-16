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
public class MyLink implements MyNode
{
	private final String target;
	private final List<MyNode> children;

	public static MyLink link(String target, MyNode content)
	{
		return MyLink.builder().target(target).children(List.of(content)).build();
	}
}
