package org.slothsclub.tdengineinsight.bind;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(oneOf = {
        MetaDNode.class,
        MetaMNode.class,
        MetaQNode.class,
        MetaCluster.class,
        MetaDatabase.class,
        MetaFunction.class,
        MetaIndex.class,
        MetaStable.class,
        MetaTable.class,
        MetaTag.class,
        MetaColumn.class,
        MetaUser.class,
        MetaConfig.class,
        MetaDnodeVariable.class,
        MetaTopic.class,
        MetaSubscription.class
})
public class Meta  {

}
