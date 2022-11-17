package com.cloud.auth.service;
import com.cloud.auth.entity.Group;
import scala.Int;

import java.util.List;

public interface GroupService {
    List<Group> getGroupList();
}
