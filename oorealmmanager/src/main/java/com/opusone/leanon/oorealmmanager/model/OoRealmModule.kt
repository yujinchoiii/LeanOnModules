package com.opusone.leanon.oorealmmanager.model

import io.realm.annotations.RealmModule

@RealmModule(library = true,
    classes = arrayOf(
        OoRmUser::class,
        OoRmPartner::class,
        OoRmScaleDevice::class,
        OoRmMessage::class,
        OoRmGuardian::class,
        OoRmSenior::class,
        OoRmMedicine::class,
        OoRmUser::class,
        OoRmAlbumPicture::class
    )
)
class OoRealmModule
