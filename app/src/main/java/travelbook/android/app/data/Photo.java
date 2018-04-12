package travelbook.android.app.data;

import android.support.annotation.Nullable;

/**
 * A data class which represents Photo entity.
 */
public final class Photo {

    private final long id;
    private final String uri;
    private final String text;
    private final boolean isPrimary;
    private final Memory memory;

    private Photo(long id, String uri, String text, boolean isPrimary, Memory memory) {
        this.id = id;
        this.uri = uri;
        this.text = text;
        this.isPrimary = isPrimary;
        this.memory = memory;
    }

    public long getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    @Nullable
    public String getText() {
        return text;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    @Nullable
    public Memory getMemory() {
        return memory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public final static class Builder {

        private long id;
        private String uri;
        private String text;
        private boolean isPrimary;
        private Memory memory;

        private Builder() {
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder isPrimary(boolean isPrimary) {
            this.isPrimary = isPrimary;
            return this;
        }

        public Builder memory(Memory memory) {
            this.memory = memory;
            return this;
        }

        public Photo build() {
            return new Photo(id, uri, text, isPrimary, memory);
        }
    }
}
