package com.opusone.leanon.realmprovider.OoDataManager.model

import io.realm.annotations.RealmModule

@RealmModule(library = true, classes = arrayOf(OoUser::class, OoPartners::class))
class OoRealmModule {
}