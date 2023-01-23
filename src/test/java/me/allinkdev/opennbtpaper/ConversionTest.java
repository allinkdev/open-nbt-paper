package me.allinkdev.opennbtpaper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import me.allinkdev.opennbtpaper.wrapper.tag.collection.CompoundTagConverter;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.Test;

class ConversionTest {

	private static final CompoundTag nbt = new CompoundTag();

	static {
		nbt.putString("string", "yes");
		nbt.putByte("byte", (byte) 5);
		nbt.putBoolean("bool", true);
		nbt.putDouble("double", 1.3D);
		nbt.putByteArray("byteArray", new byte[]{3, 6, 1, 4});
		nbt.putFloat("float", 0.5f);
		nbt.putInt("int", 69);
		nbt.putIntArray("intArray", new int[]{69, 420});
		nbt.putLong("long", 19426828418L);
		nbt.putLongArray("longArray", new long[]{1848151L, -191858L});
		nbt.putShort("short", (short) 3);
		nbt.putUUID("uuid", Util.NIL_UUID);
		nbt.putUUID("uuid2", UUID.randomUUID());
	}

	@Test
	void conversionToAndBack() {
		final com.github.steveice10.opennbt.tag.builtin.CompoundTag stevie = CompoundTagConverter.convert(
			nbt, "");

		final CompoundTag vanilla = CompoundTagConverter.reverse(stevie);
		assertEquals(nbt, vanilla);
	}
}
