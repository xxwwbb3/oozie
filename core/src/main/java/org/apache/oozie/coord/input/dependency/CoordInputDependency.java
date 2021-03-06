/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.oozie.coord.input.dependency;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.oozie.CoordinatorActionBean;
import org.apache.oozie.command.CommandException;
import org.apache.oozie.dependency.ActionDependency;
import org.jdom.Element;
import org.jdom.JDOMException;

public interface CoordInputDependency {

    public static final String INTERNAL_VERSION_ID = "V=1";

    /**
     * Adds the input instance list.
     *
     * @param inputEventName the input event name
     * @param inputInstanceList the input instance list
     */
    public void addInputInstanceList(String inputEventName, List<CoordInputInstance> inputInstanceList);

    /**
     * Gets the missing dependencies.
     *
     * @return the missing dependencies
     */
    public String getMissingDependencies();

    /**
     * Checks if dependencies are meet.
     *
     * @return true, if dependencies are meet
     */
    public boolean isDependencyMet();

    /**
     * Checks if is unresolved dependencies met.
     *
     * @return true, if unresolved dependencies are met
     */
    public boolean isUnResolvedDependencyMet();

    /**
     * Sets the dependency meet.
     *
     * @param isMissingDependenciesMet the new dependency met
     */
    public void setDependencyMet(boolean isMissingDependenciesMet);

    /**
     * Serialize.
     *
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public String serialize() throws IOException;

    /**
     * Gets the missing dependencies as list.
     *
     * @return the missing dependencies as list
     */
    public List<String> getMissingDependenciesAsList();

    /**
     * Gets the available dependencies as list.
     *
     * @return the available dependencies as list
     */
    public List<String> getAvailableDependenciesAsList();

    /**
     * Sets the missing dependencies.
     *
     * @param missingDependencies the new missing dependencies
     */
    public void setMissingDependencies(String missingDependencies);

    /**
     * Adds the un resolved list.
     *
     * @param name the name
     * @param tmpUnresolved the tmp unresolved
     */
    public void addUnResolvedList(String name, String tmpUnresolved);

    /**
     * Gets the available dependencies.
     *
     * @param dataSet the data set
     * @return the available dependencies
     */
    public List<String> getAvailableDependencies(String dataSet);

    /**
     * Adds the to available dependencies.
     *
     * @param availDepList the avail dep list
     */
    public void addToAvailableDependencies(Collection<String> availDepList);

    /**
     * Check push missing dependencies.
     *
     * @param coordAction the coord action
     * @param registerForNotification the register for notification
     * @return the action dependency
     * @throws CommandException the command exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JDOMException the JDOM exception
     */
    public ActionDependency checkPushMissingDependencies(CoordinatorActionBean coordAction,
            boolean registerForNotification) throws CommandException, IOException, JDOMException;

    /**
     * Check pull missing dependencies.
     *
     * @param coordAction the coord action
     * @param existList the exist list
     * @param nonExistList the non exist list
     * @return true, if successful
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JDOMException the JDOM exception
     */
    public boolean checkPullMissingDependencies(CoordinatorActionBean coordAction, StringBuilder existList,
            StringBuilder nonExistList) throws IOException, JDOMException;

    /**
     * Checks if is change in dependency.
     *
     * @param nonExistList the non exist list
     * @param missingDependencies the missing dependencies
     * @param nonResolvedList the non resolved list
     * @param status the status
     * @return true, if is change in dependency
     */
    public boolean isChangeInDependency(StringBuilder nonExistList, String missingDependencies,
            StringBuilder nonResolvedList, boolean status);

    /**
     * Check unresolved.
     *
     * @param coordAction the coord action
     * @param eAction
     * @return true, if successful
     * @throws Exception the exception
     */
    public boolean checkUnresolved(CoordinatorActionBean coordAction, Element eAction)
            throws Exception;

}
