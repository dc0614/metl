/**
 * Licensed to JumpMind Inc under one or more contributor
 * license agreements.  See the NOTICE file distributed
 * with this work for additional information regarding
 * copyright ownership.  JumpMind Inc licenses this file
 * to you under the GNU General Public License, version 3.0 (GPLv3)
 * (the "License"); you may not use this file except in compliance
 * with the License.
 *
 * You should have received a copy of the GNU General Public License,
 * version 3.0 (GPLv3) along with this library; if not, see
 * <http://www.gnu.org/licenses/>.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jumpmind.metl.core.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.jumpmind.metl.core.runtime.LogLevel;

public class AgentDeploymentSummary extends AbstractNamedObject {

    private static final long serialVersionUID = 1L;

    public static final String TYPE_FLOW = "Flow";
    
    public static final String TYPE_RESOURCE = "Resource";
    
    String projectName;
    
    String artifactId;
    
    String type;
    
    String name;

    String status = DeploymentStatus.DISABLED.name();

    String logLevel = LogLevel.DEBUG.name();

    String startType = StartType.MANUAL.name();

    String startExpression;
    
    String url;

    public AgentDeploymentSummary() {
    }

    public void copy(AgentProjectVersionFlowDeployment deployment) {
        AgentDeployment agentDeployment = deployment.getAgentDeployment();
        projectName = deployment.getProjectVersion().getName();
        copy(agentDeployment);
    }
    
    public void copy(AgentDeployment agentDeployment) {
        setId(agentDeployment.getId());
        name = agentDeployment.getName();
        type = TYPE_FLOW;
        status = agentDeployment.getStatus();
        logLevel = agentDeployment.getLogLevel();
        startType = agentDeployment.getStartType();
        startExpression = agentDeployment.getStartExpression();
        artifactId = agentDeployment.getFlowId();
    }
    
    public void setArtifactId(String rowId) {
        this.artifactId = rowId;
    }
    
    public String getArtifactId() {
        return artifactId;
    }

    public boolean isChanged(AgentDeploymentSummary o) {
        return ! new EqualsBuilder().append(getId(), o.getId()).append(projectName, o.projectName).append(type, o.type).append(name, o.name).append(status, o.status)
            .append(logLevel, o.logLevel).append(startType, o.startType).append(startExpression, o.startExpression).isEquals();
    }
        
    public boolean isFlow() {
        return type.equals(TYPE_FLOW);
    }
    
    public boolean isResource() {
        return type.equals(TYPE_RESOURCE);
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = DeploymentStatus.massage(status);
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getStartType() {
        return startType;
    }

    public void setStartType(String startType) {
        this.startType = startType;
    }

    public String getStartExpression() {
        return startExpression;
    }

    public void setStartExpression(String startExpression) {
        this.startExpression = startExpression;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
