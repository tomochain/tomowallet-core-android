package com.tomochain.wallet.core.components

import android.content.Context
import com.tomochain.wallet.core.common.di.CoreComponent
import com.tomochain.wallet.core.common.di.CoreModule
import com.tomochain.wallet.core.common.di.DaggerCoreComponent
import com.tomochain.wallet.core.w3jl.components.coreBlockchain.BlockChainService
import com.tomochain.wallet.core.w3jl.components.signer.SignerService
import com.tomochain.wallet.core.w3jl.components.tomochain.token.*
import com.tomochain.wallet.core.w3jl.config.chain.CommonChain
import com.tomochain.wallet.core.wallet.WalletSecretDataService
import com.tomochain.wallet.core.wallet.WalletService
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by cityme on 03,September,2019
 * Midsummer.
 * Ping me at nienbkict@gmail.com
 * Happy coding ^_^
 */
class WalletCore {


    private var context: WeakReference<Context>? = null
    private var config: CoreConfig = DefaultConfig()
    private var address = ""

    @Inject
    lateinit var coreBlockChainService: BlockChainService
    @Inject
    lateinit var signerService: SignerService
    @Inject
    lateinit var tokenService: TokenService
    @Inject
    lateinit var trc20TokenService: TRC20Service
    @Inject
    lateinit var trc21TokenService: TRC21Service
    @Inject
    lateinit var tokenManager: TokenManagerService
    @Inject
    lateinit var coreFunctions : CoreFunctions
    @Inject
    lateinit var walletService: WalletService
    @Inject
    lateinit var walletSecretDataService: WalletSecretDataService
    @Inject
    lateinit var walletFunctions: WalletFunctions


    companion object{

        private var instance: WalletCore? = null

        fun setup(context: WeakReference<Context>,config: CoreConfig = DefaultConfig()){
            instance = WalletCore()
            instance?.context = context
            instance?.config = config
            instance?.getCoreComponent()?.inject(instance)
        }





        private fun getInstance(address: String) : WalletCore?{
            val fAddress = address.toLowerCase()
            instance?.address = fAddress
            instance?.coreBlockChainService?.setWalletAddress(fAddress)
            instance?.signerService?.setWalletAddress(fAddress)
            instance?.tokenService?.setWalletAddress(fAddress)
            instance?.trc20TokenService?.setWalletAddress(fAddress)
            instance?.trc21TokenService?.setWalletAddress(fAddress)
            instance?.tokenManager?.setWalletAddress(fAddress)
            instance?.walletFunctions?.setWalletAddress(fAddress)
            instance?.walletSecretDataService?.setWalletAddress(fAddress)
            return instance
        }

        private fun getInstance() : WalletCore?{
            return instance
        }

        fun destroyInstance() {
            instance = null
        }


        fun getCoreFunctions() : CoreFunctions?{
            return instance?.coreFunctions
        }

        fun getWalletFunctions(walletAddress: String) : WalletFunctions?{
            return getInstance(walletAddress)?.walletFunctions
        }

        fun getTokenManager(walletAddress: String, tokenAddress: String? = null) : TokenManagerService?{
            val t = getInstance(walletAddress)?.tokenManager
            return if (tokenAddress == null) t else t?.withTokenAddress(tokenAddress)
        }

        fun getWalletSecretData(walletAddress: String) : WalletSecretDataService?{
            val s = getInstance(walletAddress)?.walletSecretDataService
            s?.setWalletAddress(walletAddress)
            return s
        }

    }

    fun getCurrentWalletAddress() : String?{
        return address
    }




    private fun getCoreComponent() : CoreComponent{
        return DaggerCoreComponent.builder()
            .coreModule(context?.let { CoreModule(it, config) }).build()
    }



}