package com.opusone.leanon.oorestmanager.restful

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest

object OoNetworkManager: OoReachable {
    private val TAG = "OoNetworkManager"

    private var connectivityManager: ConnectivityManager? = null
    private var lastNetworkID: String = ""

    private var status: OoNetworkStatus = OoNetworkStatus.LOST
        private set

    var onGlobalNetworkChangeListener: OnNetworkChangeListener? = null
        set(value) {
            field = value
            field?.apply {
                this(status)
            }
        }

    var onNetworkChangeListener: OnNetworkChangeListener? = null
        set(value) {
            field = value
            field?.apply {
                this(status)
            }
        }

    override fun isReachable(): Boolean {
        return status != OoNetworkStatus.LOST
    }

    fun init(context: Context) {
        if (connectivityManager != null) {
            return
        }

        connectivityManager = context.getSystemService(ConnectivityManager::class.java)
        connectivityManager?.let {
            val request = NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()

            it.registerNetworkCallback(request, networkCallback)
        }
    }

    fun deinit() {
        onGlobalNetworkChangeListener = null
        onNetworkChangeListener = null

        connectivityManager?.unregisterNetworkCallback(networkCallback)
        connectivityManager = null
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            lastNetworkID = network.toString()

            connectivityManager?.let {
                val networkCap = it.getNetworkCapabilities(network)
                networkCap?.let { nc ->
                    if(nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        status = OoNetworkStatus.CELLULAR

                        onGlobalNetworkChangeListener?.let {
                            it(status)
                        }
                        onNetworkChangeListener?.let {
                            it(status)
                        }
                    }

                    if(nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        status = OoNetworkStatus.WiFi

                        onGlobalNetworkChangeListener?.let {
                            it(status)
                        }
                        onNetworkChangeListener?.let {
                            it(status)
                        }
                    }
                }
            }
        }

        override fun onLost(network: Network) {
            if(lastNetworkID == network.toString() || lastNetworkID == "") {
                status = OoNetworkStatus.LOST

                onGlobalNetworkChangeListener?.let {
                    it(status)
                }
                onNetworkChangeListener?.let {
                    it(status)
                }
            }
        }
    }
}

typealias OnNetworkChangeListener = (status: OoNetworkStatus) -> Unit

enum class OoNetworkStatus(val status: Int) {
    LOST(0),
    WiFi(1),
    CELLULAR(2)
}