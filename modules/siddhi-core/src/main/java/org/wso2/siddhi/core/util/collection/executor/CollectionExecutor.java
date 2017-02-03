/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.util.collection.executor;

import org.wso2.siddhi.core.event.state.StateEvent;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEventCloner;
import org.wso2.siddhi.core.table.holder.IndexedEventHolder;

import java.util.Collection;

public interface CollectionExecutor {

    /**
     * Find the Events matching to the condition, used on the primary call
     *
     * @param matchingEvent        matching input event
     * @param indexedEventHolder   indexed EventHolder containing data
     * @param candidateEventCloner candidate event cloner
     * @return matched StreamEvent, null if no events matched. If candidateEventCloner is null it will return the actual event references.
     */
    StreamEvent find(StateEvent matchingEvent, IndexedEventHolder indexedEventHolder, StreamEventCloner candidateEventCloner);

    /**
     * Find the Events matching to the condition, used for consecutive calls from parent CollectionExecutor
     *
     * @param matchingEvent      matching input event
     * @param indexedEventHolder indexed EventHolder containing data
     * @return matched events as Set, null if Exhaustive processing need to be done.
     */
    Collection<StreamEvent> findEvents(StateEvent matchingEvent, IndexedEventHolder indexedEventHolder);

    /**
     * Checks if a matching event exist in indexedEventHolder
     *
     * @param matchingEvent      matching input event
     * @param indexedEventHolder indexed EventHolder containing data
     * @return true if a matching event is available in indexedEventHolder else false
     */
    boolean contains(StateEvent matchingEvent, IndexedEventHolder indexedEventHolder);

    /**
     * Delete matching events exists from indexedEventHolder
     *
     * @param deletingEvent      matching input event
     * @param indexedEventHolder indexed EventHolder containing data
     */
    void delete(StateEvent deletingEvent, IndexedEventHolder indexedEventHolder);
}