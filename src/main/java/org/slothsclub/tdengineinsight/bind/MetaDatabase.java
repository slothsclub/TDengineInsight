package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaDatabase extends Meta {
    String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createTime;
    int vgroups;
    int ntables;
    int replica;
    String strict;
    String duration;
    String keep;
    int buffer;
    int pagesize;
    int pages;
    int minrows;
    int maxrows;
    int comp;
    String precision;
    String status;
    String retentions;
    boolean singleStable;
    String cachemodel;
    int cachesize;
    int walLevel;
    int WalFsyncPeriod;
    int WalRetentionPeriod;
    int WalRetentionSize;
    int WalRollPeriod;
    long WalSegmentSize;
    int sstTrigger;
    int tablePrefix;
    int tableSuffix;
    int tablePagesize;
}
