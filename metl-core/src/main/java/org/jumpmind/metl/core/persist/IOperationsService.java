package org.jumpmind.metl.core.persist;

import java.util.List;
import java.util.Map;

import org.jumpmind.metl.core.model.AbstractObject;
import org.jumpmind.metl.core.model.Agent;
import org.jumpmind.metl.core.model.AgentDeployment;
import org.jumpmind.metl.core.model.AgentDeploymentSummary;
import org.jumpmind.metl.core.model.AgentName;
import org.jumpmind.metl.core.model.AgentResource;
import org.jumpmind.metl.core.model.AuditEvent;
import org.jumpmind.metl.core.model.Folder;
import org.jumpmind.metl.core.model.GlobalSetting;
import org.jumpmind.metl.core.model.Group;
import org.jumpmind.metl.core.model.Notification;
import org.jumpmind.metl.core.model.Resource;
import org.jumpmind.metl.core.model.Setting;
import org.jumpmind.metl.core.model.User;
import org.jumpmind.metl.core.model.UserHist;
import org.jumpmind.properties.TypedProperties;

public interface IOperationsService {
    
    public void save(AbstractObject obj);
    
    public void save(Setting setting);

    public void delete(Agent agent);

    public void delete(AgentDeployment agentDeployment);

    public Agent findAgent(String agentId, boolean includeDeployments);

    public AgentDeployment findAgentDeployment(String id);

    public List<AgentDeploymentSummary> findAgentDeploymentSummary(String agentId);

    public AgentResource findAgentResource(String agentId, Resource resource);

    public List<Agent> findAgents();

    public List<AgentName> findAgentsInFolder(Folder folder);

    public List<Notification> findNotifications();

    public List<Notification> findNotificationsForAgent(String agentId);

    public List<Notification> findNotificationsForDeployment(AgentDeployment deployment);

    public List<AuditEvent> findAuditEvents(int limit);
    
    public User findUser(String id);

    public User findUserByLoginId(String loginId);

    public List<UserHist> findUserHist(String id);

    public List<User> findUsers();

    public List<User> findUsersByGroup(String groupId);
    
    public void refresh(Group group);

    public void refresh(Notification notification);

    public void refresh(User user);

    public void refreshAgentParameters(Agent agent);
    
    public GlobalSetting findGlobalSetting(String name);

    public List<GlobalSetting> findGlobalSettings();

    public TypedProperties findGlobalSetttingsAsProperties();

    public Map<String, String> findGlobalSettingsAsMap();

    public Group findGroup(String id);

    public List<Group> findGroups();
    
    public void savePassword(User user, String newPassword);
    
    public boolean isUserLoginEnabled();

    public Group findGroupByName(String name);
        
    public void delete(User user);

    public void delete(Group group);
    
    public void save(AgentDeployment agentDeployment);

}
