package com.tomochain.wallet.core.w3jl.config.chain

/**
 * Created by cityme on 03,September,2019
 * Midsummer.
 * Ping me at nienbkict@gmail.com
 * Happy coding ^_^
 */
enum class CommonChain : Chain {

    TOMO_CHAIN {
        override fun getEndpoint(): String {
            return "https://rpc.tomochain.com"
        }

        override fun getChainName(): String {
            return "TomoChain"
        }

        override fun getChainId(): Int {
            return 88
        }

        override fun getExplorerURL(): String {
            return "https://scan.tomochain.com"
        }

        override fun getCoinBaseUnit(): String {
            return "TomoChain"
        }

        override fun getCoinBaseSymbol(): String {
            return "TOMO"
        }

        override fun getHDPath(): String {
            return "M/44H/889H/0H/0/0"
        }
    },

    TOMO_CHAIN_TEST_NET {
        override fun getEndpoint(): String {
            return "https://testnet.tomochain.com"
        }

        override fun getChainName(): String {
            return "TomoChain TestNet"
        }

        override fun getChainId(): Int {
            return 89
        }

        override fun getExplorerURL(): String {
            return "https://scan.testnet.tomochain.com"
        }

        override fun getCoinBaseUnit(): String {
            return "TomoChain"
        }

        override fun getCoinBaseSymbol(): String {
            return "TOMO"
        }

        override fun getHDPath(): String {
            return "M/44H/889H/0H/0/0"
        }
    },

    TOMO_CHAIN_DEV_NET {
        override fun getEndpoint(): String {
            return "https://rpc.devnet.tomochain.com"
        }

        override fun getChainName(): String {
            return "TomoChain DevNet"
        }

        override fun getChainId(): Int {
            return 90
        }

        override fun getExplorerURL(): String {
            return "https://scan.devnet.tomochain.com"
        }

        override fun getCoinBaseUnit(): String {
            return "TomoChain"
        }

        override fun getCoinBaseSymbol(): String {
            return "TOMO"
        }

        override fun getHDPath(): String {
            return "M/44H/889H/0H/0/0"
        }
    }
}