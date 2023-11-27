/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/


package org.apache.cayenne.exp.parser;

import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.util.ConversionUtil;

/**
 * "Not Like" expression.
 * 
 */
public class ASTNotLike extends PatternMatchNode {

    ASTNotLike(int id) {
        super(id, false);
    }

    public ASTNotLike() {
        super(ExpressionParserTreeConstants.JJTNOTLIKE, false);
    }

    public ASTNotLike(SimpleNode path, Object value) {
        super(ExpressionParserTreeConstants.JJTNOTLIKE, false);
        jjtAddChild(path, 0);
        jjtAddChild(wrap(value), 1);
        connectChildren();
    }

    public ASTNotLike(SimpleNode path, Object value, char escapeChar) {
        super(ExpressionParserTreeConstants.JJTNOTLIKE, false, escapeChar);
        jjtAddChild(path, 0);
        jjtAddChild(wrap(value), 1);
        connectChildren();
    }

    @Override
    protected int getRequiredChildrenCount() {
        return 2;
    }

    @Override
    protected Boolean evaluateSubNode(Object o, Object[] evaluatedChildren) throws Exception {
        String s1 = ConversionUtil.toString(o);
        if (s1 == null) {
            return Boolean.FALSE;
        }

        return matchPattern(s1) ? Boolean.FALSE : Boolean.TRUE;
    }

    /**
     * Creates a copy of this expression node, without copying children.
     */
    @Override
    public Expression shallowCopy() {
        return new ASTNotLike(id);
    }

    @Override
    protected String getExpressionOperator(int index) {
        return "not like";
    }

    @Override
    public int getType() {
        return Expression.NOT_LIKE;
    }
}