/*
 * Copyright 2018 Alex Thomson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.lxgaming.jump.event;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent;
import org.spongepowered.api.event.impl.AbstractEvent;

public class ChangeFlyEvent extends AbstractEvent implements TargetPlayerEvent, Cancellable {
    
    private final Cause cause;
    private final boolean elytra;
    private final boolean flying;
    private final Player player;
    private boolean cancelled = false;
    
    public ChangeFlyEvent(Player player, boolean flying, boolean elytra, Cause cause) {
        this.player = player;
        this.flying = flying;
        this.elytra = elytra;
        this.cause = cause;
    }
    
    @Override
    public Cause getCause() {
        return cause;
    }
    
    public boolean isElytra() {
        return elytra;
    }
    
    public boolean isFlying() {
        return flying;
    }
    
    @Override
    public Player getTargetEntity() {
        return player;
    }
    
    @Override
    public boolean isCancelled() {
        return cancelled;
    }
    
    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}