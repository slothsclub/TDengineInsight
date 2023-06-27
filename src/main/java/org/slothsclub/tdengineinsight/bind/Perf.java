package org.slothsclub.tdengineinsight.bind;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(oneOf = {
        PerfClient.class,
        PerfConnection.class,
        PerfConsumer.class,
        PerfQuery.class,
        PerfSma.class,
        PerfTran.class
})
public class Perf {
}
