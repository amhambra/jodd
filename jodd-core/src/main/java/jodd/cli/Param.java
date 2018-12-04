// Copyright (c) 2003-present, Jodd Team (http://jodd.org)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

package jodd.cli;

import java.util.function.Consumer;

public class Param {
	String label;
	int required = 0;
	int optional = 1;
	String description;
	Consumer<String[]> consumer;

	public Param required(final int required) {
		this.required = required;
		return this;
	}

	public Param optional(final int optional) {
		this.optional = optional;
		return this;
	}

	public Param required() {
		this.required = 1;
		this.optional = 0;
		return this;
	}

	public Param optional() {
		this.required = 0;
		this.optional = 1;
		return this;
	}

	public Param all() {
		this.optional = 1_000_000;      // magic number indicating *ALL* parameters
		return this;
	}

	public Param range(final int required, final int max) {
		this.required = required;
		this.optional = max - required;
		return this;
	}

	public Param label(final String label) {
		this.label = label;
		return this;
	}

	public Param description(final String description) {
		this.description = description;
		return this;
	}

	public Param with(final Consumer<String[]> consumer) {
		this.consumer = consumer;
		return this;
	}
}
