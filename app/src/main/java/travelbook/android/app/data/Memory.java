package travelbook.android.app.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * A data class which represents Memory entity.
 */
public final class Memory {

    private final long id;
    private final String description;
    private final List<Photo> photos;

    private Memory(long id, String description, List<Photo> photos) {
        this.id = id;
        this.description = description;
        this.photos = photos;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Nullable
    public List<Photo> getPhotos() {
        return photos;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public final static class Builder {

        private long id;
        private String description;
        private List<Photo> photos;

        private Builder() {
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder photos(List<Photo> photos) {
            this.photos = photos;
            return this;
        }

        public Memory build() {
            return new Memory(id, description, photos);
        }
    }
}

