package app.com.chatapp.utility;

/*
 * Copyright 2014 Pedro Álvarez Fernández <pedroafa@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import app.com.chatapp.utility.round.BorderedRoundedAvatarDrawable;
import app.com.chatapp.utility.round.RoundedAvatarDrawable;
import app.com.chatapp.utility.square.DoubleSquaredAvatarDrawable;
import app.com.chatapp.utility.square.QuadrupleSquaredAvatarDrawable;
import app.com.chatapp.utility.square.SquaredAvatarDrawable;
import app.com.chatapp.utility.square.TripleSquaredAvatarDrawable;
import app.com.chatapp.utility.square.utils.SquareCanvasProvider;
import app.com.chatapp.utility.square.utils.SquareUtils;


public class AvatarDrawableFactory {

    private final AvatarBorder mAvatarBorder;
    private final SquareCanvasProvider mSquareCanvasProvider;

    public AvatarDrawableFactory(Resources resources) {
        mAvatarBorder = new AvatarBorder(resources);
        mSquareCanvasProvider = new SquareCanvasProvider(new SquareUtils(), mAvatarBorder);
    }

    public RoundedAvatarDrawable getRoundedAvatarDrawable(Bitmap bitmap) {
        return new RoundedAvatarDrawable(bitmap);
    }

    public BorderedRoundedAvatarDrawable getBorderedRoundedAvatarDrawable(Bitmap bitmap) {
        return new BorderedRoundedAvatarDrawable(mAvatarBorder, bitmap);
    }

    public Drawable getSquaredAvatarDrawable(Bitmap bitmap) {
        return new SquaredAvatarDrawable(mSquareCanvasProvider, bitmap);
    }

    public Drawable getSquaredAvatarDrawable(Bitmap leftBitmap, Bitmap rightBitmap) {
        return new DoubleSquaredAvatarDrawable(mSquareCanvasProvider, leftBitmap, rightBitmap);
    }

    public Drawable getSquaredAvatarDrawable(Bitmap leftBitmap, Bitmap rightBitmapTop, Bitmap rightBitmapBottom) {
        return new TripleSquaredAvatarDrawable(mSquareCanvasProvider, leftBitmap, rightBitmapTop, rightBitmapBottom);
    }

    public Drawable getSquaredAvatarDrawable(Bitmap leftBitmapTop, Bitmap leftBitmapBottom, Bitmap rightBitmapTop,
                                             Bitmap rightBitmapBottom) {
        return new QuadrupleSquaredAvatarDrawable(mSquareCanvasProvider, leftBitmapTop, leftBitmapBottom, rightBitmapTop,
                rightBitmapBottom);
    }
}
