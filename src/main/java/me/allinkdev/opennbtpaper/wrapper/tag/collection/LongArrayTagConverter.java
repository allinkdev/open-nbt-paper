package me.allinkdev.opennbtpaper.wrapper.tag.collection;


import com.github.steveice10.opennbt.tag.builtin.LongArrayTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class LongArrayTagConverter extends NoConstructor {

	public static LongArrayTag convert(net.minecraft.nbt.LongArrayTag original,
		@Nullable String name) {
		final long[] value = original.getAsLongArray();

		return new LongArrayTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.LongArrayTag reverse(LongArrayTag original) {
		final long[] value = original.getValue();

		return new net.minecraft.nbt.LongArrayTag(value);
	}
}
