package org.cloudfoundry.client.lib.domain;

import java.util.List;
import java.util.Map;

import org.cloudfoundry.AllowNulls;
import org.cloudfoundry.client.lib.domain.annotation.Nullable;
import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableCloudApplication.class)
@JsonDeserialize(as = ImmutableCloudApplication.class)
public abstract class CloudApplication extends CloudEntity implements Derivable<CloudApplication> {

    public enum State {
        UPDATING, STARTED, STOPPED
    }

    @Value.Default
    public int getMemory() {
        return 0;
    }

    @Value.Default
    public int getDiskQuota() {
        return 0;
    }

    @Value.Default
    public int getInstances() {
        return 1;
    }

    @Value.Default
    public int getRunningInstances() {
        return 0;
    }

    @Nullable
    public abstract State getState();

    @Nullable
    public abstract Staging getStaging();

    @Nullable
    public abstract PackageState getPackageState();

    @Nullable
    public abstract String getStagingError();

    public abstract List<String> getUris();

    public abstract List<String> getServices();

    @AllowNulls
    public abstract Map<String, String> getEnv();

    @Nullable
    public abstract CloudSpace getSpace();

    @Override
    public CloudApplication derive() {
        return this;
    }

}
