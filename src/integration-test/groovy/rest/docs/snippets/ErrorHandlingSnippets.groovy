/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package rest.docs.snippets

import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.ResponseFieldsSnippet

import static org.springframework.restdocs.payload.PayloadDocumentation.*

class ErrorHandlingSnippets {

    static final ResponseFieldsSnippet commandObjectSnippet = responseFields(
            fieldWithPath("[].field").type(JsonFieldType.STRING).description('The field that has the roor'),
            fieldWithPath("[].bindingFailure").type(JsonFieldType.BOOLEAN).description('If the error was binding related.'),
            fieldWithPath("[].rejectedValue").type(JsonFieldType.VARIES).description('The value for the field that was rejected'),
            fieldWithPath("[].message").type(JsonFieldType.STRING).description('The error message rendered using i18n mappings.')
    )

    static final ResponseFieldsSnippet nonExistingUrlSnippet = responseFields(
            fieldWithPath("path").type(JsonFieldType.STRING).description("The path that doesn't exist."),
            fieldWithPath("message").type(JsonFieldType.STRING).description('The error message.')

    )


    static final ResponseFieldsSnippet notFoundSnippet = responseFields(
            fieldWithPath("error").type(JsonFieldType.NUMBER).description('The Not found error.'),
            fieldWithPath("message").type(JsonFieldType.STRING).description('The error message if there is one.')
    )
}
