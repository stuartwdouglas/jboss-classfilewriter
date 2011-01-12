/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.stuartdouglas.classfilewriter.attributes;

import java.io.DataOutputStream;
import java.io.IOException;

import com.stuartdouglas.classfilewriter.constpool.ConstPool;

public class SignatureAttribute extends Attribute {

    public static final String NAME = "Signature";

    private final String signature;
    private final int signatureIndex;

    public SignatureAttribute(final ConstPool constPool, String signature) {
        super(NAME, constPool);
        this.signature = signature;
        this.signatureIndex = constPool.addUtf8Entry(signature);
    }

    @Override
    public void writeData(DataOutputStream stream) throws IOException {
        stream.writeInt(2); // data length
        stream.writeShort(signatureIndex);
    }
}
