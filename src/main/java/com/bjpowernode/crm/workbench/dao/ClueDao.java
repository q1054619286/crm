package com.bjpowernode.crm.workbench.dao;

import com.bjpowernode.crm.workbench.domain.Clue;

public interface ClueDao {
    int save(Clue clue);

    Clue detail(String id);

    Clue getId(String clueId);

    int delete(String clueId);
}
