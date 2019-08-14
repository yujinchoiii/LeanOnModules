package com.opusone.leanon.oorealmmanager.model

import io.realm.annotations.RealmModule

@RealmModule(library = true, classes = arrayOf(OoRmUser::class, OoRmPartner::class, OoRmScaleDevice::class))
class OoRealmModule {
}