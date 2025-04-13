import id.devnzr.configuration.ConventionBundle
import id.devnzr.configuration.ConventionDependency
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class OkhttpRetrofitConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            dependencies {
                add("implementation", platform(ConventionDependency.okhttpBom))
                ConventionBundle.okhttpDependencies.forEach {
                    add("implementation", it)
                }
                ConventionBundle.retrofitDependencies.forEach {
                    add("implementation", it)
                }
            }
        }
    }
}