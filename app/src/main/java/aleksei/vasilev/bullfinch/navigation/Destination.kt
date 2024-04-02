package aleksei.vasilev.bullfinch.navigation

enum class NavigationDestination(val destination: String) {
    HOME("home"),
    PERMISSIONS("permissions");

    companion object {
        fun getNavigationDestination(destination: String?): NavigationDestination {
            NavigationDestination.entries.forEach {
                if (it.destination == destination) {
                    return it
                }
            }
            return HOME
        }
    }
}