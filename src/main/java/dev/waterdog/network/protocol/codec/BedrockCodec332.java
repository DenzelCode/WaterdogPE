/*
 * Copyright 2021 WaterdogTEAM
 * Licensed under the GNU General Public License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.waterdog.network.protocol.codec;

import com.nukkitx.protocol.bedrock.BedrockPacketCodec;
import com.nukkitx.protocol.bedrock.packet.*;
import com.nukkitx.protocol.bedrock.v332.BedrockPacketHelper_v332;
import com.nukkitx.protocol.bedrock.v332.serializer.*;
import dev.waterdog.network.protocol.ProtocolVersion;

public class BedrockCodec332 extends BedrockCodec313 {

    @Override
    public ProtocolVersion getProtocol() {
        return ProtocolVersion.MINECRAFT_PE_1_9;
    }

    @Override
    public void buildCodec(BedrockPacketCodec.Builder builder) {
        super.buildCodec(builder);
        builder.helper(BedrockPacketHelper_v332.INSTANCE);

        builder.deregisterPacket(ResourcePacksInfoPacket.class);
        builder.registerPacket(ResourcePacksInfoPacket.class, ResourcePacksInfoSerializer_v332.INSTANCE, 6);

        builder.deregisterPacket(TextPacket.class);
        builder.registerPacket(TextPacket.class, TextSerializer_v332.INSTANCE, 9);

        builder.deregisterPacket(StartGamePacket.class);
        builder.registerPacket(StartGamePacket.class, StartGameSerializer_v332.INSTANCE, 11);

        builder.deregisterPacket(AddPaintingPacket.class);
        builder.registerPacket(AddPaintingPacket.class, AddPaintingSerializer_v332.INSTANCE, 22);

        builder.deregisterPacket(NetworkStackLatencyPacket.class);
        builder.registerPacket(NetworkStackLatencyPacket.class, NetworkStackLatencySerializer_v332.INSTANCE, 115);

        builder.deregisterPacket(LevelSoundEventPacket.class);
        builder.registerPacket(LevelSoundEventPacket.class, LevelSoundEventSerializer_v332.INSTANCE, 123);
    }
}
