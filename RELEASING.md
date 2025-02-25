Releasing
=========

### Prerequisite: Sonatype (Maven Central) Account

Create an account on the [Sonatype issues site][sonatype_issues]. Ask an existing publisher to open
an issue requesting publishing permissions for `com.squareup` projects.

### Prerequisite: GPG Keys

Generate a GPG key (RSA, 4096 bit, 3650 day) expiry, or use an existing one. You should leave the
password empty for this key.

```
$ gpg --full-generate-key
```

Upload the GPG keys to public servers:

```
$ gpg --list-keys --keyid-format LONG
/Users/johnbarber/.gnupg/pubring.kbx
------------------------------
pub   rsa4096/XXXXXXXXXXXXXXXX 2019-07-16 [SC] [expires: 2029-07-13]
      YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
uid           [ultimate] John Barber <jbarber@squareup.com>
sub   rsa4096/ZZZZZZZZZZZZZZZZ 2019-07-16 [E] [expires: 2029-07-13]

$ gpg --send-keys --keyserver keyserver.ubuntu.com XXXXXXXXXXXXXXXX
```

### Prerequisite: Gradle Properties

Define publishing properties in `~/.gradle/gradle.properties`:

```
signing.keyId=1A2345F8
signing.password=
signing.secretKeyRingFile=/Users/jbarber/.gnupg/secring.gpg
```

`signing.keyId` is the GPG key's ID. Get it with this:

   ```
   $ gpg --list-keys --keyid-format SHORT
   ```

`signing.password` is the password for this key. This might be empty!

`signing.secretKeyRingFile` is the absolute path for `secring.gpg`. You may need to export this
file manually with the following command where `XXXXXXXX` is the `keyId` above:

   ```
   $ gpg --keyring secring.gpg --export-secret-key XXXXXXXX > ~/.gnupg/secring.gpg
   ```


Cutting a JVM Release
---------------------

1. Update `CHANGELOG.md`.

2. Set versions:

    ```
    export RELEASE_VERSION=X.Y.Z
    export NEXT_VERSION=X.Y.Z-SNAPSHOT
    ```

3. Set environment variables with your [Sonatype credentials][sonatype_issues].

    ```
    export SONATYPE_NEXUS_USERNAME=johnbarber
    export SONATYPE_NEXUS_PASSWORD=`pbpaste`
    ```

4. Update, build, and upload:

    ```
    sed -i "" \
      "s/VERSION_NAME=.*/VERSION_NAME=$RELEASE_VERSION/g" \
      `find . -name "gradle.properties"`
    sed -i "" \
      "s/\"com.squareup.wire:\([^\:]*\):[^\"]*\"/\"com.squareup.wire:\1:$RELEASE_VERSION\"/g" \
      `find . -name "README.md"`
    sed -i "" \
      "s/\<version\>\([^<]*\)\<\/version\>/\<version\>$RELEASE_VERSION\<\/version\>/g" \
      `find . -name "README.md"`
    ./gradlew -p wire-library clean publish uploadArchives --no-daemon --no-parallel
    ```

5. Visit [Sonatype Nexus][sonatype_nexus] to promote (close then release) the artifact. Or drop it
   if there is a problem!

6. Tag the release, prepare for the next one, and push to GitHub.

    ```
    git commit -am "Prepare for release $RELEASE_VERSION."
    git tag -a $RELEASE_VERSION -m "Version $RELEASE_VERSION"
    sed -i "" \
      "s/VERSION_NAME=.*/VERSION_NAME=$NEXT_VERSION/g" \
      `find . -name "gradle.properties"`
    git commit -am "Prepare next development version."
    git push && git push --tags
    ```

7. Deploy the documentation website.

    ```
    ./deploy_website.sh
    ```

 [sonatype_issues]: https://issues.sonatype.org/
 [sonatype_nexus]: https://oss.sonatype.org/


Publishing the Swift CocoaPods
------------------------------

There are two Podspecs to publish to CocoaPods: the Swift Wire runtime and the Swift Wire compiler. The same version number should be used for both.

CocoaPods are published to the [trunk](https://blog.cocoapods.org/CocoaPods-Trunk/) repo, which is the main public repo for all CocoaPods. If you have not published Wire before then you'll need to [get set up to publish to trunk](https://guides.cocoapods.org/making/getting-setup-with-trunk.html), and be added as a publisher for the Wire Podspecs.

### Setting the Version

When publishing a new version, two things must be done:
1. The version must be tagged in Git. So if you're publishing version `4.0.0-alpha1`, then you'd check out the SHA you want to publish and run:
```
git tag 4.0.0-alpha1
git push origin refs/tags/4.0.0-alpha1
```

2. The version being published needs to be passed into the Podspecs. This is done by setting the `POD_VERSION` environment variable:
```
export POD_VERSION=4.0.0-alpha1
```

If publishing a release version (like `4.0.0` rather than `4.0.0-alpha1`) then setting the `POD_VERSION` is optional and it will be pulled automatically from `wire-library/gradle.properties`.

### Publishing the Podspecs

After setting the version as described above, you can publish the two Podspecs by doing:

```
# Tests are currently failing, thus --skip-tests is required
pod trunk push Wire.podspec --skip-tests
```

and

```
pod trunk push WireCompiler.podspec
```
